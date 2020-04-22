import axios from 'axios';
import API_URL from "./config";


const ApiService = {
    
    getTeam(params: string) {
        
        return axios.get(`${API_URL}/search/findByTeamName?teamName=${params}`).catch(error => {
            throw new Error(`Team Metrics ${error}`);
        });
    },

    getNames() {
        return axios.get(`${API_URL}/names`).catch(error => {
            throw new Error(`Team Names ${error}`)
        });
    }
};

export default ApiService;