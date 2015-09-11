require 'gcm'

class GcmTokenController < ApplicationController
  
  def get_token

  	# save the token in database
  	token = params[:token] 
  	t = Token.new(:token => token)
  	t.save

	# send welcome mesaage to the token's device
	gcm = GCM.new("AIzaSyAzna2zpNnAgiSHvVSM2ZsjYx_wpEhzq10")
	registration_ids= [token] # an array of one or more client registration IDs
	options = {data: {score: "123"}, collapse_key: "updated_score"}
	response = gcm.send(registration_ids, options)

  end
  
end
