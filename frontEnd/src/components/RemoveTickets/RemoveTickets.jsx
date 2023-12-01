import { NavLink } from "react-router-dom";

import './RemoveTickets.css';

import VQRImage from '../../images/vqr_yellow.webp'
import TicketLarge from "./TicketLarge/TicketLarge";

const RemoveTickets = () => {

    const props = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11']; 

    const tickets = props.map(data => (<TicketLarge props={data} />))

    return(
        <div className='wrapper' style={{flexDirection: 'column'}}>

        <div style={{display: 'flex', height: '114px', width: '100%', justifyContent: 'space-between'}}>
            <div style={{display: 'flex'}}>
                <div style={{display: 'flex', flexDirection: 'column', height: '101px'}}>
                    <div id='vqr_img_wrapper'>
                        <img id='vqr_img' src={VQRImage}/>
                    </div>
                    <div className='yellow_small'>VQR</div>
                </div>  
                <div className='yellow_large' style={{marginLeft: '25px'}}>Remove Tickets</div>
            </div>
            <div className='text'>
                Search:&nbsp;
                <input className='input search' />
            </div>
        </div>

        <div className="list_large">
            { tickets }
        </div>

        <div style={{display: 'flex'}}>
            <NavLink to='/menu' id='exit_button' style={{left: '45px', top: '13px', alignSelf: 'center', height: '45px', width: '132px'}}>
                <div className='button btn_yellow button_text'>Back</div>
            </NavLink>
        </div>

        </div>
    );
}

export default RemoveTickets;