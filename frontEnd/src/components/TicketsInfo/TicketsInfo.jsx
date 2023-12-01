import { NavLink } from "react-router-dom";

import './TicketsInfo.css';

import VQRImage from '../../images/vqr_yellow.webp'
import Ticket from "./Ticket/Ticket";

const TicketsInfo = () => {

    const props = [ '01', '02','03',
                    '11', '12','13',
                    '21', '22','23',
                    '31', '32','33',
                    '41', '42','43',
                    '51', '52','53',
                    '61', '62','63',
                    '71', '72','73',
                  ]; 

    const tickets = props.map(data => (<Ticket props={data} />))

    return(
        <div className='wrapper' style={{flexDirection: 'column'}}>

        <div style={{display: 'flex', height: '114px', width: '100%', justifyContent: 'space-between'}}>
            <div style={{display: 'flex'}}>
                <div style={{display: 'flex', flexDirection: 'column', height: '101px'}}>
                    <div id='vqr_img_wrapper'>
                        <img id='vqr_img' src={VQRImage} alt=''/>
                    </div>
                    <div className='yellow_small'>VQR</div>
                </div>  
                <div className='yellow_large' style={{marginLeft: '25px'}}>Tickets</div>
            </div>
            <div className='text'>
                Search:&nbsp;
                <input className='input search' />
            </div>
        </div>

        <div className="list">
            { tickets }
        </div>

        <div style={{display: 'flex'}}>
            <NavLink to='/menu' id='exit_button' style={{left: '45px', top: '0', alignSelf: 'center', height: '45px', width: '132px'}}>
                <div className='button btn_yellow button_text'>Back</div>
            </NavLink>
            <div style={{display: 'flex', width: '100%', justifyContent: 'space-around', margin: '40px'}}>
                <div className='text'><input type='checkbox' className='input_checkbox' />&nbsp;Senhas enviadas</div>
                <div className='text'><input type='checkbox' className='input_checkbox' />&nbsp;Todas as senhas</div>
                <div className='text'><input type='checkbox' className='input_checkbox' />&nbsp;Senhas vendidas</div>
                <div className='text'><input type='checkbox' className='input_checkbox' />&nbsp;Senhas livres</div>
            </div>
        </div>

        </div>
    );
}

export default TicketsInfo;