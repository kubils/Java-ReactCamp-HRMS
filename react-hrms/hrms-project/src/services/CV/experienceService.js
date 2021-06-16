import axios from "axios";

export default class ExperienceService {

    getByDateOfFinishSorted(candidateId) {

        return axios.get("http://localhost:8080/api/experience/getByDateOfFinishSorted?candidateId="+ candidateId)
    }

    postDataToExperience(data) {
        axios.post('http://localhost:8080/api/experience/add/', data)
            .then(response => {
                alert("Successful " + response.status);
            })
    }

}