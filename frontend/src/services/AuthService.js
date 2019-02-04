import router from '../router'
import axios from 'axios'

export default{

    attemptLogin(formData, success, err){
        axios.post("/auth",
            formData,
        )
            .then((resp) => {
                if (resp.status === 200) {
                    window.localStorage.setItem("token", resp.data);
                    if(success)
                        success(resp);
                    router.push("/");
                }
            })
            .catch((error) => {
                //handle error
                if (error.response) {
                    if(err) err(error);
                    alert("wrong credentials");
                }
            })
        ;
    }
}