import axios from "axios";


export default class JobPostService {

    getJobsPost() {

        //get producs from backend host
        return axios.get("http://localhost:8080/api/jobs/getAll-jobs")
    }

    getJobByActivitySituation(activity) {

        return axios.get("http://localhost:8080/api/jobs/getByActivitySituation?isActive=", activity)
    }

    getJobsByEmployersId(id) {
        return axios.get("http://localhost:8080/api/jobs/getByEmployersId?employerId=", id)
    }

    getByActiveJobsByEmployerId(id) {
        return axios.get("http://localhost:8080/api/jobs/getByIsActiveAndEmployerId", id)
    }


    postDataToJobs(data) {
        axios.post('http://localhost:8080/api/jobs/add-job', data)
            .then(response => {
                alert("Successful " + response.status);
            })
    }

    postDataToJobDisable(id) {
        axios.post('http://localhost:8080/api/jobs/jobs/setJobDisabled?id', id)
            .then(response => {
                alert("Successful " + response.status);
            })
    }

    deleteDataFromJobs = (id) => {
        axios.post('http://localhost:8080/api/JobsPost/delete/',id)
            .then(response => {
                alert("Successful " + response.status);
            })
    }



}
