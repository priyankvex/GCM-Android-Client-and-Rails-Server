class Token < ActiveRecord::Base
	validates :token, presence: true  
	validates_uniqueness_of :token
end
