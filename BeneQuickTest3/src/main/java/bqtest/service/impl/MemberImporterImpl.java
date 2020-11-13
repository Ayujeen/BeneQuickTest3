package bqtest.service.impl;

import bqtest.service.Member;
import bqtest.service.MemberImporter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MemberImporterImpl implements MemberImporter {

    public List<Member> importMembers(File inputFile) throws IOException {
        return Files.lines(inputFile.toPath())
                .map(line -> {
                    //TODO implement here
                    Member newMember= new Member();
                    newMember.setId(line.substring(0, 11));
                    newMember.setLastName(line.substring(12, 36));
                    newMember.setFirstName(line.substring(37, 61));
                    newMember.setAddress(line.substring(62, 91));
                    newMember.setCity(line.substring(92, 111));
                    newMember.setState(line.substring(112, 115));
                    newMember.setZip(line.substring(116, 120));
                    return newMember;
                }).collect(Collectors.toList());
    }

}
