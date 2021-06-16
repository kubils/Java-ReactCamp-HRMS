import axios from "axios";

export default class SchoolService {

    getSchoolsByDateOfFinishSorted(candidateId) {

        return axios.get("http://localhost:8080/api/schools/getByDateOfFinishSorted?candidateId="+ candidateId)
    }


    postDataToSchool(data) {
        axios.post('http://localhost:8080/api/schools/add/', data)
            .then(response => {
                alert("Successful " + response.status);
            })
    }

}