import axios from "axios";

export default class WorkTypeService {

    getWorkPlace() {
        return axios.get('http://localhost:8080/workType/getAll')
    }
}