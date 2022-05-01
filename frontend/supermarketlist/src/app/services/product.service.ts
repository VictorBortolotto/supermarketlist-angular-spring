const API_URL = "http://localhost:8080/products";

export const ProductsService = () => {
    return fetch(API_URL + '/all', {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Content-Type': 'application.json',
            'Authorization': `Bearer ${JSON.parse(localStorage.getItem('user')|| '').token}`
        }
    }).then(async (response) => {
        const data = await response.json()
        return data;
    })
} 