package com.example.demo.ministry;

import com.example.demo.database.school.dto.SchoolDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MinistryServiceImpl implements MinistryService {
    MinistryRequestToDatabase databaseService;

    public SchoolDto returnSchoolById(int id) {
        //Логика проверки запроса
        return databaseService.getSchoolById(id);
    }

    public void deleteSchoolById(int id) {
        //Логика проверки запроса
        databaseService.deleteSchool(id);
    }

    public List<SchoolDto> returnAllSchool() {
        //Логика проверки запроса
        return databaseService.getAllSchool();
    }
}
