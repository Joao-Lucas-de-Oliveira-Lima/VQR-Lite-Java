import './TicketLarge.css';

const Ticket = () => {
    return(
        <div className='ticket_large'>
            <div className='ticket_large__number'>33</div>
            <div className='ticket_large__content text'>
                <div style={{display: 'flex', flexDirection: 'row'}}>
                    <div style={{display: 'flex', flexDirection: 'column'}}>
                        <div style={{marginLeft: '18px'}}>PUXADOR: FRANCISCO ANTONIO SILVA</div>
                        <div style={{marginLeft: '18px'}}>ESTEIRA: PEREIRA FRANÇA</div>
                        <div style={{marginLeft: '18px'}}>REPRESENTAÇÃO: IMPUEIRAS CLUB</div>
                        
                    </div>
                    <div style={{display: 'flex', flexDirection: 'column'}}>
                        <div style={{marginLeft: '18px'}}>CAVALOS: PAMPO</div>
                        <div style={{marginLeft: '18px'}}>CAVALOS: SOG</div>
                        <div style={{marginLeft: '18px'}}>ESTADO: CEARÁ</div>
                    </div>
                    <div style={{display: 'flex', flexDirection: 'column', alignItems: 'center', marginLeft: '30px'}}>
                        <div>MUNICÍPIO: IMPUEIRAS</div>
                        <div className='text_large'>CPF: 546.368.321-77</div>
                    </div>
                </div>
            </div>
            <div className='button_remove__wrapper'>
                <div className='button button_text button_remove'>LIBERAR</div>
            </div>
            <div className='ticket_large__decoration'>
                <span className="dot"></span>
                <span className="dot"></span>
                <span className="dot"></span>
            </div>
        </div>
    );
}

export default Ticket;