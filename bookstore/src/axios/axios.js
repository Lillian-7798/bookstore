import axios from 'axios';
const instance = axios.create(
    {
        baseURL: 'http://localhost:8080',
        timeout: 5000,
        withCredentials: true, // 跨域请求时发送Cookie
        headers:{
            'Content-type':'application/x-www-form-urlencoded'
        }
    });
export {instance};