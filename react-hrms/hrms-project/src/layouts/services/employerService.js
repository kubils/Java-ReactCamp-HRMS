import axios from "axios";


export default class EmployerService {

    getEmployers() {

        //get producs from backend host
        return axios.get("http://localhost:8080/api/employers/getall/employers")
    }
}
