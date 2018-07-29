const formatTimeDetail = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatTime = date => {
  const hour = date.getHours()
  const minute = date.getMinutes()

  return  [hour, minute].map(formatNumber).join(':')
}

const formatYear = date => {
  const year = date.getFullYear()

  return [year].map(formatNumber)
}

const formatMonth = date => {
  const month = date.getMonth() + 1

  return [month].map(formatNumber)
}

const formatDate = date => {
  const month = date.date.getMonth() + 1
  const day = date.getDate()
  return [month,day].map(formatNumber).join("-");
}


const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

module.exports = {
  formatTimeDetail: formatTimeDetail,
  formatTime:formatTime,
  formatYear:formatYear,
  formatMonth:formatMonth,
  formatDate:formatDate
}
