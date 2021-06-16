import axios from "axios";

export default class ImageService {

    postImageToServer (candidateId, data) {

        axios.post('http://localhost:8080/api/images/upload/',candidateId, data)
        .then(response => {
            alert("Successful " + response.status);
        })
    }

     getImagesAll() {

        return axios.get("http://localhost:8080/api/images/getAll")
        
    }

    getImageByCandidateId(id) {

        return axios.get("http://localhost:8080/api/images/getByCandidates_Id?candidateId="+ id)
    }

    deleteImage = (id) => {
        axios.post('http://localhost:8080/api/images/delete/', id)
            .then(response => {
                alert("Successful " + response.status);
            })
    }
}
