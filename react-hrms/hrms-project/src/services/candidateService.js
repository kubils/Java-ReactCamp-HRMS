import axios from "axios";


export default class CandidateService {

    getCandidates() {

        //get producs from backend host
        return axios.get("http://localhost:8080/api/candidates/getAll/candidates")
    }

    getCandidatesById(id) {
        return axios.get("http://localhost:8080/api/candidates/getById?id="+ id)
    }

    postDataToCandidate(data) {
        axios.post('http://localhost:8080/api/candidates/add/candidates', data)
            .then(response => {
                alert("Successful " + response.status);
            })
    }

    deleteDataFromCandidate = (id) => {
        axios.post('http://localhost:8080/api/candidates/delete/', id)
            .then(response => {
                alert("Successful " + response.status);
            })
    }
}
