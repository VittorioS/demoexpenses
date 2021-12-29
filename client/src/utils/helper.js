import axios from "./axios"

const newExpense = (item) => ({
    ...item,
    id: item._links.self.href.split('/').pop(),
    date: new Date(item.date)
})

export const getExpenses = async () => {
    try {
        const response = await axios.get('/items', {})
        console.log(response)
        const data = response.data._embedded.items.map(newExpense)
        return data
    } catch (ex) {
        console.log(ex)
        throw ex
    }
}

export const createExpenses = async (expense) => {
    try {
        const response = await axios.post('/items', expense)
        console.log(response)
        const data = newExpense(response.data)
        return data
    } catch (ex) {
        console.log(ex)
        throw ex
    }
}

export const deleteExpenses = async (id) => {
    try {
        await axios.delete('/items/' + id)
    } catch (ex) {
        console.log(ex)
        throw ex
    }
}
