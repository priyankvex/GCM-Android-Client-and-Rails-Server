require 'gcm'

class GcmTokenController < ApplicationController
  
  def get_token

  	# save the token in database
  	token = params[:token] 
  	t = Token.new(:token => token)
  	t.save

	# A rediculously funny welcome message.
  	welcome_message = "Welcome! You have been registered. Buy some nice gas balloons with your name on it."
  	
	# send welcome mesaage to the token's device
	gcm = GCM.new("AIzaSyAzna2zpNnAgiSHvVSM2ZsjYx_wpEhzq10")
	registration_ids= [token] # an array of one or more client registration IDs
	options = {data: {message: welcome_message}, collapse_key: "updated_score"}
	response = gcm.send(registration_ids, options)

  end
  
end
