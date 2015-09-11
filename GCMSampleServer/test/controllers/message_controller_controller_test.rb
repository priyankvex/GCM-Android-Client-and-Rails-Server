require 'test_helper'

class MessageControllerControllerTest < ActionController::TestCase
  test "should get send_message" do
    get :send_message
    assert_response :success
  end

end
