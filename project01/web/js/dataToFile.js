
/**
 * 将base64转换成file
 */
export function dataToFile(base64, fileName){

    const parts = base64.split(';base64,')
    const contentType = parts[0].split(':')[1]
    const raw = window.atob(parts[1])
    const rawLength = raw.length

    const uInt8Array = new Uint8Array(rawLength)

    for (let i = 0; i < rawLength; ++i) {
        uInt8Array[i] = raw.charCodeAt(i)
    }
    return new File([uInt8Array], fileName, {type: contentType, lastModified: Date.now()})
}