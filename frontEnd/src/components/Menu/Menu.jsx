import { NavLink } from "react-router-dom";

import './Menu.css';

import VQRImage from '../../images/vqr_white.webp';
import SellTicketsImage from '../../images/menu_images/sell_tickets.webp';
import RemoveTicketsImage from '../../images/menu_images/remove_tickets.webp';
import TicketsInfoImage from '../../images/menu_images/ticket_info.webp';
import ScheduleImage from '../../images/menu_images/schedule.webp';
import CreateStuffImage from '../../images/menu_images/create_stuff.webp';
import FinanceImage from '../../images/menu_images/finance.webp';
import NearestEventsImage from '../../images/menu_images/nearest_events.webp';
import MenuImage from '../../images/menu_images/menu.webp';


const Menu = () => {
    return(
      <div className='wrapper'>

        <div className='sidebar_large'>
            <div id='sidebar_large_vqr_img_wrapper'>
                <img id='sidebar_large_vqr_img' src={VQRImage} alt=''/>
            </div>
            <div id='sidebar_large_vqr_text_wrapper'>
                <div className='white_large'>VQR</div>
            </div>
            <img id='sidebar_large_image' src={MenuImage} alt=''/>
            <NavLink to='/menu' id='exit_button'>
                <div className='button button_text'>Exit</div>
            </NavLink>
        </div>

        <div id='menu_container'>
            <div className='yellow_large' id='menu_title'>
                <div>Menu</div>
            </div>

            <NavLink to="/sell_tickets" id='sell_tickets_button'>
                <div className='button btn_yellow'>
                    <img src={SellTicketsImage} className='vector' id='sell_ticket_img' style={{width: '30px', height: '24px', left: '12px'}} alt=''/>
                    <div className='button_text'>Sell Tickets</div>
                </div>
            </NavLink>
            <NavLink to="/remove_tickets" id='remove_tickets_button'>
                <div className='button btn_yellow'>
                    <img src={RemoveTicketsImage} className='vector' id='remove_ticket_img' style={{width: '23px', height: '16px', left: '16px', top: '16px'}} alt=''/>
                    <div className='button_text'>Remove Tickets</div>
                </div>
            </NavLink>
            <NavLink to="/tickets_info" id='tickets_info_button'>
                <div className='button btn_yellow'>
                    <img src={TicketsInfoImage} className='vector' id='ticket_info_img' style={{width: '24px', height: '32px', left: '15px', top: '12px'}} alt=''/>
                    <div className='button_text'>Tickets Info</div>
                </div>
            </NavLink>
            <NavLink to="/schedule" id='schedule_button'>
                <div className='button btn_yellow'>
                    <img src={ScheduleImage} className='vector' id='schedule_img' style={{width: '26px', height: '26 px', left: '12px', top: '12px'}} alt=''/>
                    <div className='button_text'>Schedule</div>
                </div>
            </NavLink>
            <NavLink to="/create_stuff" id='create_stuff_button'>
                <div className='button btn_yellow'>
                    <img src={CreateStuffImage} className='vector' id='create_stuff_img' style={{width: '25px', height: '27px', left: '12px'}} alt=''/>
                    <div className='button_text'>Create Staff</div>
                </div>
            </NavLink>
            <NavLink to="/finance" id='finance_button'>
                <div className='button btn_yellow'>
                    <img src={FinanceImage} className='vector' id='finance_img' style={{width: '27px', height: '27px', left: '13px'}} alt=''/>
                    <div className='button_text'>Finance</div>
                </div>
            </NavLink>

            <NavLink to="/finance" id='nearest_events_button'>
                <div className='button btn_red'>
                    <img src={NearestEventsImage} className='vector' id='nearest_events_img' alt=''/>
                    <div className='button_text'>Nearest events</div>
                </div>
            </NavLink>
        </div>

      </div>
    );
  }
  
export default Menu;
  