package com.bcp.democosmosdb.core.documents;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

@Container(containerName = "StudentDocumentLv")
public class StudentDocument {
    @Id
    @GeneratedValue
    private String id;
    private String firstName;
    @PartitionKey
    private String lastName;
    private AdrressDocument address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AdrressDocument getAddress() {
        return address;
    }

    public void setAddress(AdrressDocument address) {
        this.address = address;
    }
}
