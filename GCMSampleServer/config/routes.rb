Rails.application.routes.draw do
  
  get 'message_controller/send_message'
  post 'message_controller/send_message'

  post 'gcm_token/get_token'
end
