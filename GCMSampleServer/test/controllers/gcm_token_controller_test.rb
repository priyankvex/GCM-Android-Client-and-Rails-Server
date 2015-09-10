require 'test_helper'

class GcmTokenControllerTest < ActionController::TestCase
  test "should get get_token" do
    get :get_token
    assert_response :success
  end

end
