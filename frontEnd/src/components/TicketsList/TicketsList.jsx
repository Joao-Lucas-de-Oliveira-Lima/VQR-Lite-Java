import './TicketsList.css';

const TicketsList = () => {

    let props = [];

    for (let i = 1; i <= 100; i++) {
        props[i] = [i, Math.round(Math.random()) === 0 ? '' : 'occupied' ];
    }

    const tickets = props.map(data => {
        const style = `text ticket_box ${data[1]}`;
        return (<div className={style}>{data[0]}</div>);
    });

    return(
        <div style={{alignSelf: 'center'}}>

            <div className='text' style={{justifyContent: 'center', marginBottom: '10px'}}>Senhas:</div>

            <div className='tickets_list'>
                {tickets}
            </div> 

            <div className='text' style={{marginTop: '24px', marginLeft: '25px', fontSize: '13px'}}>Senhas indisponíveis:&nbsp;<div style={{backgroundColor: 'red', width: '41px', height: '17px'}}></div></div>

        </div>
    );
}

export default TicketsList;