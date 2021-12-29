import React, { useState, useEffect } from "react"

import "./ExpenseFormFullscreen.css"

const _formatDate = (date) => {
  return date.toJSON().substr(0, 10)
}

const ExpenseForm = (props) => {
  const [step, setStep] = useState(0)
  const [title, setTitle] = useState("")
  const [amount, setAmount] = useState("")
  const [date, setDate] = useState("")

  const handleTitleChange = (oEvent) => {
    setTitle(oEvent.target.value)
  }
  const handleAmountChange = (oEvent) => {
    setAmount(oEvent.target.value)
  }
  const handleDateChange = (oEvent) => {
    setDate(oEvent.target.value)
  }

  const handleSubmit = (oEvent) => {
    oEvent.preventDefault()
    save()
  }

  const save = () => {
    const next = step + 1
    if (next % steps.length !== 0) {
      setStep(next)
      return
    }

    const oExpenseData = {
      title: title,
      amount: +amount,
      date: new Date(date),
      // date: new Date(),
    }
    props.onSaveExpenseData(oExpenseData)
    setTitle("")
    setAmount("")
    // setDate(_formatDate(new Date()))
    setDate("")
  }

  useEffect(() => {
    if (date !== "") {
      save()
    }
  }, [date])

  const steps = [
    <div className="new-expense__controls">
      <div className="new-expense__control">
        <label>Titolo</label>
        <input
          value={title}
          onChange={handleTitleChange}
          type="text"
          required
        />
      </div>
    </div>,
    <div className="new-expense__controls">
      <div className="new-expense__control">
        <label>Costo</label>
        <input
          value={amount}
          onChange={handleAmountChange}
          type="number"
          min="0.01"
          step="0.01"
          required
        />
      </div>
    </div>,
    <div className="new-expense__controls">
      <div className="new-expense__control">
        <label>Data</label>
        <input
          value={date}
          onChange={handleDateChange}
          type="date"
          min="2019-01-01"
          max="2022-12-31"
          required
        />
      </div>
    </div>,
  ]

  return (
    <form className="new-expense--form" onSubmit={handleSubmit}>
      {steps[step]}
    </form>
  )
}

export default ExpenseForm
