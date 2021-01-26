package com.bcp.democosmosdb.core.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.bcp.democosmosdb.core.documents.StudentDocument;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CosmosRepository<StudentDocument,String> {
    public List findByLastName(String lastName);
}
