const websocket = (userid,handleMessage)=>{
    const USERID = userid;
    const socketUrl = `ws://localhost:8080/isCheckoutSuccess/${USERID}`;
    console.log(socketUrl)
    const ws = new WebSocket(socketUrl);

    const init = () => {
        ws.addEventListener('open', handleOpen, false);
        ws.addEventListener('close', handleClose, false);
        ws.addEventListener('error', handleError, false);
        ws.addEventListener('message', handleMessage, false);
    };

    function handleOpen(e) {
        console.log('WebSocket open', e);
    }

    function handleClose(e) {
        console.log('WebSocket close', e);
        console.log("websocket close!!!!!!!!!!!!!");
    }

    function handleError(e) {
        console.log('WebSocket error', e);
        console.log("websocket error!!!!!!!!!!!!!");

    }

    init();
    return ws;

}
export default websocket;