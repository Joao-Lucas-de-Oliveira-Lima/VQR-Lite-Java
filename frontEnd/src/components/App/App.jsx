import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Menu from '../Menu/Menu';
import SellTickets from '../SellTickets/SellThikets';
import RemoveTickets from '../RemoveTickets/RemoveTickets';
import TicketsInfo from '../TicketsInfo/TicketsInfo';
import Schedule from '../Schedule/Schedule';
import CreateStuff from '../CreateStuff/CreateStuff';
import Finance from '../Finance/Finance';

const App = () => {
  return(
    <div className='app'>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Menu />}/>
          <Route path='/menu' element={<Menu />}/>
          <Route path='/sell_tickets' element={<SellTickets />}/>
          <Route path='/remove_tickets' element={<RemoveTickets />}/>
          <Route path='/tickets_info' element={<TicketsInfo />}/>
          <Route path='/schedule' element={<Schedule />}/>
          <Route path='/create_stuff' element={<CreateStuff />}/>
          <Route path='/finance' element={<Finance />}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
