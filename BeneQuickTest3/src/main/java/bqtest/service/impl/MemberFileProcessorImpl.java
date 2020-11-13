package bqtest.service.impl;

import bqtest.service.Member;
import bqtest.service.MemberFileProcessor;
import bqtest.service.MemberImporter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberFileProcessorImpl extends MemberFileProcessor {

    /*
     * Implement methods here
     */

    @Override
    protected MemberImporter getMemberImporter() {
       return (new MemberImporterImpl());
    }

    @Override
    protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
        //Here I am getting non duplicate members per state as asked in question. But if same member is in different state, that is allowed.
        List <List> stateandidchecklist=new ArrayList<>();
        List <Member> nonDuplicatePerState=new ArrayList<>();
        
        for(int i=0;i<membersFromFile.size();i++){
            List <String> stateandid=new ArrayList<>();
            stateandid.add(membersFromFile.get(i).getState());
            stateandid.add(membersFromFile.get(i).getId());
            //System.out.println(ee);
            if(!stateandidchecklist.contains(stateandid)){
                stateandidchecklist.add(stateandid);
                nonDuplicatePerState.add(membersFromFile.get(i));
            }
        }
        
        return nonDuplicatePerState;
    }

    @Override
    protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
        /*
        Since there should be no duplicate members per state only and duplicate members can be allowed in different states, in my opinion
        getduplicatemembers() should have been checked after splitting members by state. In this way, members in certain states only, could be tested
        to look for duplicate members. I think calling splitmembers() after getduplicatemembers in this scenario creates a little redundancy.
        */
        List<String> states= new ArrayList<>();

        Map<String, List<Member>> mapped_by_state= new HashMap<>();
        
        for(int i=0;i<validMembers.size();i++){
            if (!states.contains(validMembers.get(i).getState())){
                states.add(validMembers.get(i).getState());
            }	
        } 

        for(int i=0;i<states.size();i++){
            List <Member> dataset_by_state= new ArrayList<>();
            for(int j=0;j<validMembers.size();j++){
                if(states.get(i).equals(validMembers.get(j).getState())){
                    dataset_by_state.add(validMembers.get(j));
                }       
            }         
            mapped_by_state.put(states.get(i), dataset_by_state);
        }

        return mapped_by_state;
        
    }

}
