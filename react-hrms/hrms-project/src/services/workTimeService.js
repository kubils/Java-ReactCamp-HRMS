import axios from "axios";

export default class WorkTimeService {

    getEmploymentTime() {
        return axios.get('http://localhost:8080/worktime/getAll')
    }
}