import axios from 'axios';

export default class ResumeService {

    getResumes() {

        //get producs from backend host
        return axios.get("http://localhost:8080/api/resume/getAll")
    }
}
