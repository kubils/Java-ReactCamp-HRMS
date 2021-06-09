import axios from "axios";


export default class JobPostService {

    getJobsPost() {

        //get producs from backend host
        return axios.get("http://localhost:8080/api/jobs/getAll-jobs")
    }
}
