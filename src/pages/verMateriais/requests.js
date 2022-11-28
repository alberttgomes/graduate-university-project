import axios from "axios"

const header = {
    "Authorization": "Bearer ",
    "Content-Type": "application/json"
}
  
export const getAdolescents = () => {
    axios.get('http://localhost:8080/adolescents', header)
}

export const getAdults = () => {
    axios.get('http://localhost:8080/adults', header)
}

export const getKids = () => {
    axios.get('http://localhost:8080/kids', header)
}