import './Ticket.css';

const Ticket = () => {
    return(
        <div className='ticket'>
            <div className='ticket__number'>33</div>
            <div className='ticket__content text'>
                <div>P:&nbsp;FRANCISCO ANTONIO SILVA</div>
                <div>E:&nbsp;RAIMUNDO PEREIRA FRANÇA</div>
                <div>R:&nbsp;IMPUEIRAS CLUB</div>
            </div>
            <div className='ticket__decoration'>
                <span className="dot"></span>
                <span className="dot"></span>
                <span className="dot"></span>
            </div>
        </div>
    );
}

export default Ticket;