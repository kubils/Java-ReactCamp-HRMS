import axios from "axios";

export default class LanguageService {

    getByCandidates_Id(candidateId) {

        return axios.get("http://localhost:8080/api/languages/getByCandidates_Id?candidateId=", candidateId)
    }

    postDataToLanguage(data) {
        axios.post('http://localhost:8080/api/languages/add/', data)
            .then(response => {
                alert("Successful " + response.status);
            })
    }
}   