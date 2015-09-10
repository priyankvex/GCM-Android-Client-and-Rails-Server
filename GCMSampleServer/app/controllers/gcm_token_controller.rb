require 'gcm'

class GcmTokenController < ApplicationController
  
  def get_token

  	puts params[:token]
	gcm = GCM.new("AIzaSyAzna2zpNnAgiSHvVSM2ZsjYx_wpEhzq10")
	registration_ids= [params[:token]] # an array of one or more client registration IDs
	options = {data: {score: "123"}, collapse_key: "updated_score"}
	response = gcm.send(registration_ids, options)

  end
end
