import React from 'react';

import './ExpensesFilter.css';

const ExpensesFilter = (props) => {

  const handleChangeValue = (event) => {
    props.onYearSelection(event.target.value);
  };

  return (
    <div className='expenses-filter'>
      <div className='expenses-filter__control'>
        <label>Filtra per anno</label>
        <select value={props.year} onChange={handleChangeValue}>
          <option value='2022'>2022</option>
          <option value='2021'>2021</option>
          <option value='2020'>2020</option>
          <option value='2019'>2019</option>
        </select>
      </div>
    </div>
  );
};

export default ExpensesFilter;