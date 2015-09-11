class CreateMessageControllers < ActiveRecord::Migration
  def change
    create_table :message_controllers do |t|
      t.string :send_message

      t.timestamps null: false
    end
  end
end
