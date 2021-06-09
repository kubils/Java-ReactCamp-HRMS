import axios from "axios";

export default class JobTitleService {

    getJobTitles() {

        return axios.get("http://localhost:8080/api/job-titles/getAll-jobTitles")
    }

    postDataJobTitle(data) {
        axios.post('http://localhost:8080/api/job-titles/add', data)
            .then(response => {
                alert("Successful " + response.status);
            })
    }

    deleteDataFromJobTitle = (id) => {
        axios.post('http://localhost:8080/api/job-titles/delete/', id)
            .then(response => {
                alert("Successful " + response.status);
            })
    }
}
