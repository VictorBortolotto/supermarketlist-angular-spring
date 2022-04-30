const API_URL = 'http://localhost:8080/auth';

export const SigninService = (email: string, password: string) => {
    return fetch(API_URL + '/signin', {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email,
            password
        }),
    }).then(async (response) => {
        const data = await response.json();
        if(data.accessToken){
            localStorage.setItem('user', JSON.stringify(data))
        }
        
        return data;
    })
}