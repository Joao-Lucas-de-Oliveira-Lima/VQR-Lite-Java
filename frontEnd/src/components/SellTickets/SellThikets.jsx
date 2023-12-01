import { NavLink } from "react-router-dom";

import './SellTickets.css';

import VQRImage from '../../images/vqr_white.webp'
import TicketsList from "../TicketsList/TicketsList";

const SellTickets = () => {
    return(
        <div className='wrapper'>

            <div className='sidebar'>
                <div id='sidebar_vqr_img_wrapper'>
                    <img id='sidebar_vqr_img' src={VQRImage} alt=''/>
                </div>
                <div className='white_large'>VQR</div>
                <NavLink to='/menu' id='back_to_menu_button'>
                    <div className='button button_text'>Back</div>
                </NavLink>
            </div> 

            <div className='container'>
                <div className='yellow_large' id='sell_title'>Sell Tickets</div>

                <div className='text' id='puller'>PUXADOR:&nbsp;<input className='input' placeholder='Nome do puxador'/></div>
                <div className='text' id='horse1'>CAVALO:&nbsp;<input className='input' placeholder='Cavalo do puxador'/></div>

                <div className='text' id='helper'>ESTEIRA:&nbsp;<input className='input' placeholder='Nome do esteira'/></div>
                <div className='text' id='horse2'>CAVALO:&nbsp;<input className='input' placeholder='Cavalo do esteira'/></div>


                <div className='text' id='city'>MUNICÍPIO:&nbsp;<input className='input' placeholder='Município'/>
                    &nbsp;Estado:&nbsp;
                    <select className='text'>
                        <option>CE</option>
                        <option>RU</option>
                    </select>
                </div>

                <div className='text' id='representation'>REPRESENTAÇÃO:&nbsp;<input className='input' placeholder='Representação'/></div>

                <div className='text' id='tickets'>N° da(s) senha(s):&nbsp;<input className='input' placeholder='Número da senha'/></div>

                <div className='text' id='tv'><input type='checkbox' className='input_checkbox' />&nbsp;BOI TV&nbsp;</div>

                <div className='text' id='bonus'><input type='checkbox' className='input_checkbox' />&nbsp;BONIFICAÇÃO:&nbsp;<input className='input' placeholder='Info da Bonificação'/></div>

                <div style={{flexDirection: 'row', display: 'flex', justifyContent: 'start', paddingLeft: '51px'}}>
                    <div className='text' id='payment' style={{alignItems: 'start'}}>FORMA DE PAGAMENTO:&nbsp;</div>
                    <div id='payment_checkboxes'>
                        <div className='text'><input type='checkbox' className='input_checkbox' />&nbsp;Dinheiro</div>
                        <div className='text'><input type='checkbox' className='input_checkbox' />&nbsp;PIX</div>
                        <div className='text'><input type='checkbox' className='input_checkbox' />&nbsp;Cartão</div>
                        <div className='text'><input type='checkbox' className='input_checkbox' />&nbsp;Cheque</div>
                    </div>
                </div>
            </div>

            <TicketsList />
            
        </div>
    );
}

export default SellTickets;