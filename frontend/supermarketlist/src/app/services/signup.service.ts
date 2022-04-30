const API_URL = 'http://localhost:8080/auth';

export const SignupService = (nickname: string, email: string, password: string) => {
    return fetch(API_URL + '/signup', {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nickname,
            email,
            password
        }),
    }).then(async (response) => {
        const data = await response.json();
        return data;
    })
}
