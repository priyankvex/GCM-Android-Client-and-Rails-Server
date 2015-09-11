class MessageControllerController < ApplicationController

  def send_message
  	
  	if request.post?
  		puts "POST received!"
  		message = params[:message]
  		tokens_array = Array.new
  		@tokens = Token.all
  		@tokens.each do |t|
  			tokens_array.push(t.token)
  		end
  		# We got the tokens array. Now send GCM message to these tokens.
  		gcm = GCM.new("AIzaSyAzna2zpNnAgiSHvVSM2ZsjYx_wpEhzq10")
		options = {data: {score: message}, collapse_key: "updated_score"}
		response = gcm.send(tokens_array, options)
  	else
  		puts "GET received!"
  	end

  	puts params

  end

end
