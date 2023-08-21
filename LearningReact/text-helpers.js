export const print = (msg) => log(msg, new Date());
export const log = (msg,ts) => console.log(`${ts.toString()}: ${msg}`)

/*
export function proot(msg) {
    log(msg, new Date());
}*/