import axios from "axios";


export default class EmployerService {

    getEmployers() {

        //get producs from backend host
        return axios.get("http://localhost:8080/api/employers/getall/employers")
    }

    postDataToEmployer(data) {
        axios.post('http://localhost:8080/api/employers/add/employers', data)
            .then(response => {
                alert("Successful " + response.status);
            })
    }

    deleteDataFromEmployer = (id) => {
        axios.post('http://localhost:8080/api/employers/delete/', id)
            .then(response => {
                alert("Successful " + response.status);
            })
    }
}
