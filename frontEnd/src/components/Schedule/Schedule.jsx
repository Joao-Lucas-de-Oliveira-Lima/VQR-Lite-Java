import { NavLink } from "react-router-dom";

import './Schedule.css';

import VQRImage from '../../images/vqr_white.webp'

const Schedule = () => {
    return(
        <div className='wrapper'>

            <div className='sidebar'>
                <div id='sidebar_vqr_img_wrapper'>
                    <img id='sidebar_vqr_img' src={VQRImage}/>
                </div>
                <div className='white_large'>VQR</div>
                <NavLink to='/menu' id='back_to_menu_button'>
                    <div className='button button_text'>Back</div>
                </NavLink>
            </div> 

            <div>

            </div>

            <div>

            </div>
        </div>
    );
}

export default Schedule;