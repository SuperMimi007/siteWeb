package com.mimi.repository;

import com.mimi.modele.Report;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.io.IOException;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReportRepositoryTest {
/*

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @Rollback(false)
    public void testInsertReport() throws IOException{
        Report reportName = new Report("C:\\Users\\Mimi\\OneDrive\\Desktop\\uploads\\CR_12112022_Lucifer.pdf");
    }

*/

}
