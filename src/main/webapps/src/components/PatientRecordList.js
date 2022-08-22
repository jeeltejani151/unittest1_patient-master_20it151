import axios from "axios";
import React, { useEffect, useState } from "react";
import { Card, Container, Table, Button } from "react-bootstrap";

export default function PatientRecordList() {

    const [patientRecord, setPatientRecord] = useState([]);

    useEffect(()=>{
        axios.get("http://localhost:8080/listpatientRecord")
            .then(response=>setPatientRecord(response.data))
            .catch(error=>alert(error));

    },[])

    let deleteRecord = (id) =>{
        axios.delete("http://localhost:8080/listpatientRecord/"+id)
            .then(response=>{
                if(response.data!=null){
                    alert("Record Deleted");
                }
            });

    }


    return (
        <div className="my-3">
            <Container>
                <Card.Header><h3>Patient List</h3></Card.Header>
                <Card.Body>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th> Id</th>
                            <th>Patient Name</th>
                            <th>Patient Address</th>
                            <th>Edit/Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        {student.map(student => (
                            <tr>
                                <td>{student.id}</td>
                                <td>{student.name}</td>
                                <td>{student.address}</td>
                                <td><Button variant="primary">Edit</Button>{' '}
                                    <Button variant="secondary"onClick={()=>deleteRecord(student.id)}>Delete</Button>{' '}
                                </td>

                            </tr>
                        ))}

                        </tbody>
                    </Table>
                </Card.Body>
            </Container>
        </div>
    );
}
