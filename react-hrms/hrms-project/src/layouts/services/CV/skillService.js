import axios from "axios";

export default class SkillService {

    getSkillsByCandidates_Id(candidateId) {

        return axios.get("http://localhost:8080/api/skills/getByCandidates_Id?candidateId=", candidateId)
    }

    postDataToExperience(data) {
        axios.post('http://localhost:8080/api/skills/add/', data)
            .then(response => {
                alert("Successful " + response.status);
            })
    }
}