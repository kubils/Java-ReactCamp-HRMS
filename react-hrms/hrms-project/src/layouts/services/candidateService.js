import axios from "axios";


export default class CandidateService {

    getCandidates() {

        //get producs from backend host
        return axios.get("http://localhost:8080/api/candidates/getAll/candidates")
    }
}